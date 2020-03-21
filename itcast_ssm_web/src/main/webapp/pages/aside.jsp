<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<security:authentication property="principal.username"></security:authentication>
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">Menu</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>Home</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>System Management</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting">
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<a
									href="${pageContext.request.contextPath}/user/findAll.do"> <i
									class="fa fa-circle-o"></i> User Management
							</a>
						</security:authorize>
					</li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/role/findAll.do"> <i
							class="fa fa-circle-o"></i> Role Management
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/permission/findAll.do">
							<i class="fa fa-circle-o"></i> Authority Management
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/sysLog/findAll.do"> <i
							class="fa fa-circle-o"></i> Log
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>Database</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/product/findAll.do?page=1&size=5">
							<i class="fa fa-circle-o"></i> Product Management
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/orders/findAll.do?page=1&size=5"> <i
							class="fa fa-circle-o"></i> Order Management
					</a></li>

				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>