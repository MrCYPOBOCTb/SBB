<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: akushner
  Date: 10/9/2017
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/angular.min.js' />"></script>
<script src="<c:url value='/static/app.js'/>"></script>

<script src="<c:url value='/static/controller/indexController.js'/>"></script>

<script src="<c:url value='/static/service/fahrplanService.js' />"></script>
<script src="<c:url value='/static/controller/fahrplanController.js' />"></script>
<script src="<c:url value='/static/service/halt_service.js' />"></script>
<script src="<c:url value='/static/controller/halt_controller.js' />"></script>

<body ng-app="SBB" class="ng-cloack" ng-controller="indexController as iControl">

<h1>SBB_JS</h1>
<%--<jsp:forward page="/WEB-INF/jsp/haltestelle.jsp"/>--%>
<%--<jsp:forward page="/WEB-INF/jsp/fahrplan.jsp"/>--%>
<aside id="sideBar" style="width: 20%;border: 1px solid">
    <form name="fahrplanForm" class="form-vertical">
        <div class="generic-container">
            <div class="panel panel-default">
                <button type="button" name="Haltestelle" ng-click="haltEdit()" style="border: 1px solid">Edit
                    Haltestelle
                </button>
                <button type="button" name="Fahrplan" ng-click="fahrplanEdit()" style="border: 1px solid">Edit
                    Fahrplan
                </button>
                <%--<button type="button" name="Reisender" ng-click="">Edit Reisender</button>
                <button type="button" name="Angebot" ng-click="">Buy a Ticket</button>--%>
            </div>
        </div>
    </form>
</aside>

<section style="float:right;width:75%;border:1px solid">
    <div class="generic-container" ng-controller="FahrplanController as ctrlFahrplan" id="fahrplanContainer">
        <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">Fahrplan Form1</span></div>
            <form ng-submit="ctrlFahrplan.submit()" name="fahrplanForm" class="form-horizontal">

                <input type="hidden" ng-model="ctrlFahrplan.fahrplan.id"/>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="zugID">ZugID</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrlFahrplan.fahrplan.zugID" id="zugID"
                                   class="ZugID form-control input-sm"
                                   placeholder="ZugID" required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="haltID">Haltestelle</label>
                        <div class="col-md-7">
                            <input type="number" ng-model="ctrlFahrplan.fahrplan.haltID" id="haltID"
                                   class="haltID form-control input-sm"
                                   placeholder="Haltestelle ID"
                                   required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="bemerkung">Bemerkung</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrlFahrplan.fahrplan.bemerkung" id="bemerkung"
                                   class="Bemerkung form-control input-sm"
                                   placeholder="Bemerkung" required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="${{!ctrlFahrplan.fahrplan.id ? 'Add' : 'Update'}}"
                               class="btn btn-primary btn-sm"
                               ng-disabled="fahrplanForm.$invalid">
                        <button type="button" ng-click="ctrlFahrplan.reset()" class="btn btn-warning btn-sm"
                                ng-disabled="fahrplanForm.$pristine">Reset Form
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Fahrplan</span></div>
            <div class="tablecontainer">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID.</th>
                        <th>Halt</th>
                        <th>Zug</th>
                        <th>Zeit</th>
                        <th>Bemerkung</th>
                        <th width="20%"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="f in ctrlFahrplan.fahrplaene">
                        <td><span ng-bind="ctrlFahrplan.id"></span></td>
                        <td><span ng-bind="ctrlFahrplan.zugID"></span></td>
                        <td><span ng-bind="ctrlFahrplan.haltID"></span></td>
                        <td><span ng-bind="ctrlFahrplan.zeit"></span></td>
                        <td><span ng-bind="ctrlFahrplan.bemerkung"></span></td>
                        <td>
                            <button type="button" ng-click="ctrlFahrplan.edit(f.id)"
                                    class="btn btn-success custom-width">
                                Edit
                            </button>
                            <button type="button" ng-click="ctrlFahrplan.remove(f.id)"
                                    class="btn btn-danger custom-width">
                                Remove
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<section style="float:right;width:75%;border:1px solid">
    <div class="generic-container" ng-controller="HaltestelleController as ctrl" id="haltestelleContainer">
        <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">Haltestelle Form</span></div>
            <form ng-submit="ctrl.submit()" name="haltForm" class="form-horizontal">

                <input type="hidden" ng-model="ctrl.haltestelle.id"/>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="uic">Uic</label>
                        <div class="col-md-7">
                            <input type="number" ng-model="ctrl.haltestelle.uic" id="uic"
                                   class="uic form-control input-sm"
                                   placeholder="UIC code"
                                   required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="name">Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.haltestelle.name" id="name"
                                   class="name form-control input-sm"
                                   placeholder="Halt-Name"
                                   required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="bemerkung">Bemerkung</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.haltestelle.bemerkung" id="bemerkung"
                                   class="bemerkung form-control input-sm"
                                   placeholder="Bemerkung" required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="${{!ctrl.haltestelle.id ? 'Add' : 'Update'}}"
                               class="btn btn-primary btn-sm"
                               ng-disabled="haltForm.$invalid">
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
                                ng-disabled="haltForm.$pristine">Reset Form
                        </button>
                    </div>
                </div>
            </form>
        </div>

        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Haltestelle </span></div>
            <div class="tablecontainer">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID.</th>
                        <th>UIC</th>
                        <th>Name</th>
                        <th>Bemerkung</th>
                        <th width="20%"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="h in ctrl.haltestellen">
                        <td><span ng-bind="h.id"></span></td>
                        <td><span ng-bind="h.uic"></span></td>
                        <td><span ng-bind="h.name"></span></td>
                        <td><span ng-bind="h.bemerkung"></span></td>
                        <td>
                            <button type="button" ng-click="ctrl.edit(h.id)" class="btn btn-success custom-width">Edit
                            </button>
                            <button type="button" ng-click="ctrl.remove(h.id)" class="btn btn-danger custom-width">
                                Remove
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<%--<div class="generic-container" ng-controller="" id="angebotsAnfrage"></div>--%>

</body>
</html>
