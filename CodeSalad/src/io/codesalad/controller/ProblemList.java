package io.codesalad.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.codesalad.model.DatabaseManager;
import io.codesalad.model.Problem;

/**
 * Servlet implementation class Problems
 */
@WebServlet("/ProblemList")
public class ProblemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProblemList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String difficulty = request.getParameter("difficulty");
		System.out.println(difficulty);
		DatabaseManager newDBJob = new DatabaseManager();
		ResultSet rd;
		Problem newProblem = new Problem();
		ArrayList<Problem> ProblemObjs = new ArrayList<>();

		try {

			switch (difficulty) {
			case "B":

				rd = newDBJob.getDBConnection().executeQuery("Select * from CodeSalad.Problems where Difficulty = 'B'");
				while (rd.next()) {
					newProblem = new Problem();
					
					newProblem.difficulty="Beginner";
					newProblem.pid=rd.getString("ProbId");
					newProblem.problemName=rd.getString("Pname");
					newProblem.author=rd.getString("CreatedBy");
					newProblem.createdOn=rd.getString("CreatedOn");
					ProblemObjs.add(newProblem);

				}
				break;

			case "E":

				rd = newDBJob.getDBConnection().executeQuery("Select * from CodeSalad.Problems where Difficulty = 'E'");
				while (rd.next()) {
					newProblem = new Problem();
					newProblem.difficulty="Easy";
					newProblem.pid=rd.getString("ProbId");
					newProblem.problemName=rd.getString("Pname");
					newProblem.author=rd.getString("CreatedBy");
					newProblem.createdOn=rd.getString("CreatedOn");
					
					ProblemObjs.add(newProblem);
					

				}
				
				break;

			case "M":

				rd = newDBJob.getDBConnection().executeQuery("Select * from CodeSalad.Problems where Difficulty = 'M'");
				while (rd.next()) {
					newProblem = new Problem();
					newProblem.difficulty="Medium";
					newProblem.pid=rd.getString("ProbId");
					newProblem.problemName=rd.getString("Pname");
					newProblem.author=rd.getString("CreatedBy");
					newProblem.createdOn=rd.getString("CreatedOn");
					

					ProblemObjs.add(newProblem);
					
				}
				break;

			case "H":

				rd = newDBJob.getDBConnection().executeQuery("Select * from CodeSalad.Problems where Difficulty = 'H'");
				while (rd.next()) {
					newProblem = new Problem();
					newProblem.difficulty="Hard";
					newProblem.pid=rd.getString("ProbId");
					newProblem.problemName=rd.getString("Pname");
					newProblem.author=rd.getString("CreatedBy");
					newProblem.createdOn=rd.getString("CreatedOn");
					ProblemObjs.add(newProblem);

				}
				break;

			default:
				break;
			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("PObjs", ProblemObjs);
		for(Problem prob : ProblemObjs)
		{
			System.out.println(prob.pid+"\n");
		}
		

		RequestDispatcher newDispatcher = getServletContext().getRequestDispatcher("/Web/Questions.jsp");
		newDispatcher.forward(request, response);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

	}

}