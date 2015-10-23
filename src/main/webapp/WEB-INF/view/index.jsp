<!DOCTYPE html>
<html ng-app="myApp">
    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>GETTING STARTED WITH BRACKETS</title>
        <meta name="description" content="An interactive getting started guide for Brackets.">
        <link rel="stylesheet" href="main.css" />
		<link rel="stylesheet" href="css/bootstrap.css" /> 
      <script src="angular.min.js" type="text/javascript" ></script>
        <script>
            var  myApp = angular.module("myApp",[]);
        
			myApp.controller("myController", ['$scope','$filter','$http','$ns', function($scope,$filter,$http,$ns){
                $scope.handle = "masudjbd";
                
                $scope.fhandle = function(){
                    return $filter('lowercase')($scope.handle);
                }
				
//				$http.get("http://localhost:8080/rest/api").success(function(result){
//					$scope.employees = result;
//				});
//				
//				$scope.name=$ns.sname;
//				$scope.addEmployee = function(){
//					
//					$http.post("http://localhost:8080/rest/api", { name:$scope.name }).success(function(result){
//					
//						$scope.employees = result;
//						$scope.name='';
//					});
//				}
				
				
				$http.get('http://localhost:8080/rest/list')
					.success(function(result){
							$scope.empwithdepts = result;
						});
				
				$scope.saveE = function(){
					$http.post('http://localhost:8080/rest/add',{ name: $scope.ename, dept: { name: 'Software'}})
							   .success(function(result){
 						$scope.empwithdepts = result;
					});
				}
				
            }]);
            
            
			/* service */
          
			myApp.service('$ns',function(){
				this.sname = 'Name Service';
			});
            
			
			myApp.directive('myResult', function(){
			
				return {
					restrict : 'AECM',
					template : '<a href="#" class="list-group-item"><h4 class="list-group-item-heading">List group item heading</h4><p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p></a>',
					replace : true 
					 
				}
			});
			
        </script>
        
                <script src="app.js" type="text/javascript" ></script>

    </head>
    <body ng-controller="myController">
        
        <h1>GETTING STARTED WITH BRACKETS</h1>
        <h2>This is your guide!</h2>
        
         <div>
            <label>What is your twitter name ? </label>
             <input type="tex" id="ifield" ng-model="handle"   />
        </div>
        
        <hr />
        
        <h3>twitter.com/{{ fhandle() }}</h3>
        
		
		<div>
			
			<h3>Employee List </h3>
			
			<ul>
				<li ng-repeat="employee in employees">
					{{ employee.name }}
				</li>
			</ul>
			
			<div>
				<label>Name : </label>
				<input type="text" ng-model="name" />
				<button type="button" ng-click="addEmployee()" >Add</button>
			</div>
		</div>
		
		
		<div class="list-group">
			<my-result></my-result>
			
			<div my-result></div>
			
			<div class="my-result"></div>
			
			<!-- directive: my-result -->
		</div>
		
		
		<div class="row-fluid">
			
			<table class="table table-striped">
				
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Dept</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="ep in empwithdepts | limitTo:10 | orderBy:-ep.name">
						<td>{{ ep.id }}</td>
						<td>{{ ep.name }}</td>
						<td>{{ ep.dept.name }}</td>
						 
					</tr>
				</tbody>
			</table>
			
			<div>
				
				<label>Name :</label>
				
				<input type="text" ng-model="ename" />
			
				<button type="button" ng-click="saveE()" >Add</button>
			</div>
			
			
			 
		</div>
		
    </body>
</html>
<!--

    [[[[[[[[[[[[[[[      ]]]]]]]]]]]]]]]
    [::::::::::::::      ::::::::::::::]
    [::::::::::::::      ::::::::::::::]
    [::::::[[[[[[[:      :]]]]]]]::::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[     CODE THE WEB     ]:::::]
    [:::::[  http://brackets.io  ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [::::::[[[[[[[:      :]]]]]]]::::::]
    [::::::::::::::      ::::::::::::::]
    [::::::::::::::      ::::::::::::::]
    [[[[[[[[[[[[[[[      ]]]]]]]]]]]]]]]

-->