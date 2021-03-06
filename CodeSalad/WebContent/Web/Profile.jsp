
<!DOCTYPE html>
<html lang="en">
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Web/Header.jsp"%>


<c:set var="path" value=" ${pageContext.request.contextPath}/Web" />
<section id="page-breadcrumb">
	<div class="vertical-center sun">
		<div class="container">
			<div class="row">
				<div class="action">
					<div class="col-sm-12">
						<h1 class="title">Dashboard</h1>

					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--/#action-->


<section id="portfolio-information" class="padding-top">
	<div class="container">
		<div class="row">
		<div class="project-name overflow">
					<h1 class="bold">${profile.uname}</h1>
				</div>
			<div class="col-sm-4" style="margin-top: 2%;">

				<c:choose>
					<c:when test="${profile.pic==null}">
						<img src="${path}/images/nopic.png" class="img-responsive"
							alt="No profile pic">



					</c:when>
					<c:otherwise>

						<img src="${profile.pic}" class="img-responsive"
							alt="Error Loading Profile pic" height="300px" width="300px">

					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when
						test="${(isFromOtherUser==true) and (from != profile.email) }"></c:when>
					<c:otherwise>
						<form action="/CodeSalad/EditProfile"
							enctype="multipart/form-data" method="post">
							Upload new Picture <input type="file" name="pic"> <input
								type="submit" value="Upload">
						</form>
					</c:otherwise>
				</c:choose>



			</div>
			<div class="col-sm-6">
				
				<div class="project-info overflow">
					<h3>Problems Solved</h3>
					<c:choose>
						<c:when test="${probSolved[0].probid==null}">
					You haven't solved any problems</c:when>
						<c:otherwise>



							<div>
								<div style=" margin-right: ;">
									<table class="tableSection">
										<thead>
											<tr>
												<th><span class="text"> Problem</span></th>
												<th><span class="text"> Status </span></th>
												<th><span class="text"> Time </span></th>
												<th><span class="text"> Memory </span></th>
												<th><span class="text"> Date </span></th>
												<th><span class="text"> Language </span></th>
												

											</tr>
										</thead>



										<tbody>
											<c:forEach var="solution" items="${probSolved}"
												varStatus="index">
												<tr>
													<td><a
														href="/CodeSalad/ViewProblem?pid=${solution.probid}">${solution.problemName}</a></td>
													<td>${solution.status}</td>
													<td>${solution.execTime}</td>
													<td>${solution.execMem }</td>
													<td>${solution.submittedOn}</td>
													<td>${solution.lang}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>

			</div>

			<c:choose>
				<c:when
					test="${(isFromOtherUser==true) and (from != profile.email) }"></c:when>
				<c:otherwise>
					<div class="col-sm-2">
						<form action="/CodeSalad/Web/NewProblem.jsp">
							<input type="submit" style="display: inline;"
								value="Add new problem">
						</form>
						<form
							action="/CodeSalad/NewProblem?isFromUser=true&userMail=${profile.email}"
							method="get">
							<a
								href="/CodeSalad/ProblemList?isFromUser=true&userMail=${profile.email}"><input
								type="button" value="View your Problems"></a>
						</form>


					</div>
				</c:otherwise>
			</c:choose>







		</div>
	</div>
</section>



<footer id="footer">
	<div class="container">
		<div class="row">
			<div class="col-sm-12 text-center bottom-separator">
				<img src="images/home/under.png" class="img-responsive inline"
					alt="">
			</div>
			<div class="col-md-4 col-sm-6">
				<div class="testimonial bottom">
					<h2>Testimonial</h2>
					<div class="media">
						<div class="pull-left">
							<a href="#"><img src="images/home/profile1.png" alt=""></a>
						</div>
						<div class="media-body">
							<blockquote>Nisi commodo bresaola, leberkas venison
								eiusmod bacon occaecat labore tail.</blockquote>
							<h3>
								<a href="#">- Jhon Kalis</a>
							</h3>
						</div>
					</div>
					<div class="media">
						<div class="pull-left">
							<a href="#"><img src="images/home/profile2.png" alt=""></a>
						</div>
						<div class="media-body">
							<blockquote>Capicola nisi flank sed minim sunt
								aliqua rump pancetta leberkas venison eiusmod.</blockquote>
							<h3>
								<a href="">- Abraham Josef</a>
							</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="contact-info bottom">
					<h2>Contacts</h2>
					<address>
						E-mail: <a href="mailto:someone@example.com">email@email.com</a> <br>
						Phone: +1 (123) 456 7890 <br> Fax: +1 (123) 456 7891 <br>
					</address>

					<h2>Address</h2>
					<address>
						Unit C2, St.Vincent's Trading Est., <br> Feeder Road, <br>
						Bristol, BS2 0UY <br> United Kingdom <br>
					</address>
				</div>
			</div>
			<div class="col-md-4 col-sm-12">
				<div class="contact-form bottom">
					<h2>Send a message</h2>
					<form id="main-contact-form" name="contact-form" method="post"
						action="sendemail.php">
						<div class="form-group">
							<input type="text" name="name" class="form-control"
								required="required" placeholder="Name">
						</div>
						<div class="form-group">
							<input type="email" name="email" class="form-control"
								required="required" placeholder="Email Id">
						</div>
						<div class="form-group">
							<textarea name="message" id="message" required="required"
								class="form-control" rows="8" placeholder="Your text here"></textarea>
						</div>
						<div class="form-group">
							<input type="submit" name="submit" class="btn btn-submit"
								value="Submit">
						</div>
					</form>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="copyright-text text-center">
					<p>&copy; Your Company 2014. All Rights Reserved.</p>
					<p>
						Crafted by <a target="_blank" href="http://designscrazed.org/">Allie</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</footer>
<!--/#footer-->


<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/lightbox.min.js"></script>
<script type="text/javascript" src="js/wow.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>
