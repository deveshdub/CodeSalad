package io.codesalad.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProblemProcessor {

	public ProblemProcessor() {
		// TODO Auto-generated constructor stub
	}

	public ProblemProcessor(String ProblemText, int pid) {

	}

	public void saveProblem(String ProblemText, String pid, String Testcases) throws IOException {
		File probFolder = new File("/home/gaurav/CodeSalad/Problems/" + pid + "/");
		probFolder.mkdirs();
		File newProblem = new File("/home/gaurav/CodeSalad/Problems/" + pid + "/problem.txt");
		newProblem.createNewFile();
		FileWriter fWriter = new FileWriter(newProblem);
		fWriter.write(ProblemText);
		fWriter.flush();

		newProblem = new File("/home/gaurav/CodeSalad/Problems/" + pid + "/testcases.txt");
		newProblem.createNewFile();
		fWriter = new FileWriter(newProblem);
		fWriter.write(Testcases);
		fWriter.flush();

		fWriter.close();

	}

	public Problem getProblemData(String pid) throws ClassNotFoundException, SQLException, IOException {
		Problem newProb = new Problem();
		DatabaseManager newDbJob = new DatabaseManager();
		
		String query = "Select * from CodeSalad.Problems where ProbId = '"+pid+"'";
		ResultSet rs = newDbJob.getDBConnection().executeQuery(query);
		while(rs.next())
		{
			newProb.pid=rs.getString("ProbId");
			newProb.problemName=rs.getString("Pname");
			newProb.author=rs.getString("CreatedBy");
			newProb.createdOn=rs.getString("CreatedOn");
			newProb.difficulty=rs.getString("Difficulty");
		}
		
		File readProb = new File("/home/gaurav/CodeSalad/Problems/" + pid + "/problem.txt");
		//System.out.println("/home/gaurav/CodeSalad/Problems/" + pid + "/problem.txt");
		FileInputStream in = new FileInputStream(readProb);
		BufferedReader bRead = new BufferedReader(new InputStreamReader(in));
		String data ="";
		  StringBuffer stringBuffer = new StringBuffer();
		
		while((data =bRead.readLine())!=null)
		{
			stringBuffer.append(data).append("<br>");
			
		}
		//System.out.println(stringBuffer);
		
		newProb.problemText=stringBuffer.toString();

		return newProb;

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		

	}

}
