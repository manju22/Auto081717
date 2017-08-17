package framework;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestCaseMgmt {
	Properties prop = null;
	String JIRA_BASEURL = "";
	String PROJECT_KEY = "";
	String RELEASE_VERSION = "";
	String TESTCYCLE_NAME = "";
	String ZAPI_URI_CONTEXT = "/rest/zapi/latest/";
	String JIRA_API_CONTEXT = "/rest/api/2/";
	String PROJECT_ID = "";
	String JIRA_AUTHORIZATION = "";
	boolean AUTOEXECTIONSTATUS = false;
	
	public TestCaseMgmt() throws Exception {
		prop = new Properties();
		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream("testcasemgmt.properties");
			prop.load(input);
			AUTOEXECTIONSTATUS = Boolean.valueOf(prop.getProperty("autoexecutionstatus"));
			JIRA_BASEURL = prop.getProperty("jira.baseurl");
			PROJECT_KEY = prop.getProperty("project.key");
			RELEASE_VERSION = prop.getProperty("release.version");
			TESTCYCLE_NAME = prop.getProperty("testcycle.name");
			JIRA_AUTHORIZATION = prop.getProperty("jira.authorization");
			JIRA_AUTHORIZATION = "Basic " + JIRA_AUTHORIZATION;
			PROJECT_ID = getProjectId();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Unable to load properties file");
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private String doGet(String url) throws Exception {
		Client client = ClientBuilder.newClient();
		Response response = client.target(url)
				.request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", JIRA_AUTHORIZATION).get();
		if (response.getStatus() != 200) {
			throw new Exception("Unable to connect to JIRA");
		}
		return response.readEntity(String.class);
	}
	
	private String doPost(String url, String payload) throws Exception {
		Client client = ClientBuilder.newClient();
		Entity payloadEntity = Entity.json(payload);
		Response response = client.target(url)
				.request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", JIRA_AUTHORIZATION).post(payloadEntity);
		if (response.getStatus() != 200) {
			throw new Exception("Unable to connect to JIRA");
		}
		return response.readEntity(String.class);
	}
	
	private String doPut(String url, String payload) throws Exception {
		Client client = ClientBuilder.newClient();
		Entity payloadEntity = Entity.json(payload);
		Response response = client.target(url)
				.request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", JIRA_AUTHORIZATION).put(payloadEntity);
		if (response.getStatus() != 200) {
			throw new Exception("Unable to connect to JIRA");
		}
		return response.readEntity(String.class);
	}
	
	private String getProjectId() throws Exception {
		String projectId = "";
		String responseString = doGet(JIRA_BASEURL + JIRA_API_CONTEXT + "project/" + PROJECT_KEY);
		JSONObject obj = new JSONObject(responseString);
		projectId = obj.getString("id");
		
		if (projectId.isEmpty()) {
			throw new Exception("Unable to find the Project " + PROJECT_KEY);
		}

		return projectId;
	}
	
	private String getVersionId() throws Exception {
		String versionId = "";
		String responseString = doGet(JIRA_BASEURL + JIRA_API_CONTEXT + "project/" + PROJECT_KEY + "/versions");
		JSONArray arr = new JSONArray(responseString);
		for (Object object : arr) {
			JSONObject obj = (JSONObject) object;
			if (RELEASE_VERSION.equals(obj.getString("name"))) {
				versionId = obj.getString("id");
			}
		}
		
		if (versionId.isEmpty()) {
			throw new Exception("Unable to find the release version " + RELEASE_VERSION);
		}

		return versionId;
	}
	
	private String getCycleId() throws Exception {
		String cycleId = "";
		String responseString = doGet(JIRA_BASEURL + ZAPI_URI_CONTEXT + "cycle/?projectId" + PROJECT_ID + "&versionId=" + getVersionId());
		JSONObject obj = new JSONObject(responseString);
		Set<String> keySet = obj.keySet();
		for (String key : keySet) {
			if (key.equalsIgnoreCase("recordsCount")) {
				continue;
			}
			JSONObject jsonObject = obj.getJSONObject(key);
			if(TESTCYCLE_NAME.equals(jsonObject.getString("name"))) {
				cycleId = key;
			}
		}
		
		if (cycleId.isEmpty()) {
			cycleId = createTestCycle();
		}

		return cycleId;
	}
	
	private String createTestCycle() throws Exception {
		String cycleId = "";
				
		String payload =  "{\"clonedCycleId\": \"\", \"name\": \"" + TESTCYCLE_NAME 
				+ "\", \"build\": \"\",\"environment\": \"\",\"description\": \"Test Cycle created for Automation Framework Test Execution on" 
				+ new Date() + "\",\"startDate\": \"\",\"endDate\": \"\",\"projectId\": \"" + PROJECT_ID + "\",\"versionId\": \"" 
				+ getVersionId() + "\"}";
		
		String responseString = doPost(JIRA_BASEURL + ZAPI_URI_CONTEXT + "cycle", payload);
		JSONObject obj = new JSONObject(responseString);
		cycleId = obj.getString("id");
		
		return cycleId;
	}
	
	private String getIssueId(String jiraNo) throws Exception {
		String issueId = "";
		String responseString = doGet(JIRA_BASEURL + JIRA_API_CONTEXT + "issue/" + jiraNo + "?fields=id");
		JSONObject obj = new JSONObject(responseString);
		issueId = obj.getString("id");

		return issueId;
	}
	
	private String createExecution(String jiraNo) throws Exception {
		String payload = "{\"cycleId\": \"" + getCycleId() + "\",\"issueId\": \"" + getIssueId(jiraNo) 
						+ "\",\"projectId\": \"" + PROJECT_ID + "\",\"versionId\": \"" + getVersionId() 
						+ "\",\"assigneeType\": \"assignee\",\"assignee\": \"dhanapas\"}";
		
		String responseString = doPost(JIRA_BASEURL + ZAPI_URI_CONTEXT + "execution", payload);
		JSONObject obj = new JSONObject(responseString);
		Set<String> keySet = obj.keySet();
		String executionId = "";
		for (String key : keySet) {
			executionId = key;
		}
		return executionId;
	}
	
	public void updateExecutioStatus(String jiraNo, String status) throws Exception {
		if (!AUTOEXECTIONSTATUS) {
			return;
		}
		String executionId = createExecution(jiraNo);
		String statusId = "-1";
		if (status.equals("passed")) {
			statusId = "1";
		} else {
			statusId = "2";
		}
		String payload = "{\"status\": \"" + statusId + "\"}";
		String responseString = doPut(JIRA_BASEURL + ZAPI_URI_CONTEXT + "execution/" + executionId + "/execute", payload);
		JSONObject obj = new JSONObject(responseString);
		System.out.println("Testcase executed successfully");
	}
	
	
	/*public static void main(String[] args) throws Exception {
		TestCaseMgmt tcm = new TestCaseMgmt();
		tcm.updateExecutioStatus("QPJ-1205","failed");
	}*/

}
