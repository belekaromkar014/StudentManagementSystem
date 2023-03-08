<html>
      <head>
           <title>  APIcall </title>
           
           <script>
                   var xmlhttp;
                   function getdata(){
                	   xmlhttp=new XMLHttpRequest();
                	   xmlhttp.onload=display;
                	   var name=document.form1.name.value;
                	   xmlhttp.open("get","http://localhost:8080/getspecificdata/" + name);
                	   xmlhttp.send();
                   }
                   function show(){
                //	   alert("hello");
                	   alert(xmlhttp.responseText);
                	   var obj=JSON.parse(xmlhttp.responseText);
                	   document.form1.id.value=obj.id;
                	   document.form1.name.value=obj.name;
                	   document.form1.rollnum.value=obj.rollnum;
                	   document.form1.age.value=obj.age;
                	   document.form1.std.value=obj.std;
                   }
                   
                   function postdata(){
                	   xmlhttp=new XMLHttpRequest();
                	   xmlhttp.onload=show2;
                	   var id=document.form1.id.value;
                	   var name=document.form1.name.value;
                	   var rollnum=document.form1.rollnum.value;
                	   var age=document.form1.age.value;
                	   var std=document.form1.std.value;
                	   
                	   var obj={"id":id , "name":name , "rollnum": rollnum , "age": age , "std": std};
                	   xmlhttp.open("post" , "http://localhost:8080/insertstudent");
                	   xmlhttp.setRequestHeader('Content-type' , 'application/json');
                	   xmlhttp.send(JSON.stringify(obj));
                   }             
                   
                   function show2(){
                	   alert(xmlhttp.responseText);
                   }
                   
                   function deletedata(){
                	   xmlhttp=new XMLHttpRequest();
                	   xmlhttp.onload=show3;
                	   var name=document.form1.name.value;
                	   xmlhttp.open("delete","http://localhost:8080/deletedata/" + name);
                	   xmlhttp.send();
                   }
                   
                   function show3(){
                	   alert(xmlhttp.responseText);
                   }
                   
                   function getalldata(){
                	   xmlhttp = new XMLHttpRequest();
                	   xmlhttp.onload=display;
                	   xmlhttp.open("get" , "http://localhost:8080/getstudent");
                	   xmlhttp.send();
                   }
                   
                   
                  function display(){
                	   var table = document.getElementById("table1");
                	   table.innerHTML="";
                	   
                	   var headingrow = document.createElement("tr");
                	   
                	   var idth = document.createElement("th");
                	   var nameth = document.createElement("th");
                	   var rollnumth = document.createElement("th");
                	   var ageth = document.createElement("th");
                	   var stdth = document.createElement("th");
                	   
                	   var id = document.createTextNode("id");
                	   var name = document.createTextNode("name");
                	   var rollnum = document.createTextNode("rollnum");
                	   var age = document.createTextNode("age");
                	   var std = document.createTextNode("std");
                	   
                	   idth.appendChild(id);
                	   nameth.appendChild(name);
                	   rollnumth.appendChild(rollnum);
                	   ageth.appendChild(age);
                	   stdth.appendChild(std);
                	   
                	   headingrow.appendChild(idth);
                	   headingrow.appendChild(nameth);
                	   headingrow.appendChild(rollnumth);
                	   headingrow.appendChild(ageth);
                	   headingrow.appendChild(stdth);
                	   
                	   table.appendChild(headingrow);
                	   
                	   var data = alert(xmlhttp.responseText);
                	   alert(data);
                	   var data=data.substring(1,data.length-1);
                	   alert(data);
                	   
                	   var newstr="";
                	   for(var i=0; i<data.length; i++){
                		   var character = data[i];
                		   if(character==',' && data[i+1]=='{'){
                			   newstr = newstr + "#";
                		   }
                		   else{
                			   newstr = newstr + character;
                		   }
                	   }
                	   
                	   var jsonstring= newstr.split("#");
                	   
                	   for(var i=0; i<jsonstring.length; i++){
                		   var jsonrecord=jsonstring[i];
                		   var object=JSON.parse(jsonrecord);
                		   
                		   var row = document.createElement("tr");
                		   
                		   var idtd = document.creatrElement("td");
                    	   var nametd = document.creatrElement("td");
                    	   var rollnumtd = document.creatrElement("td");
                    	   var agetd = document.creatrElement("td");
                    	   var stdtd = document.creatrElement("td");
                		   
                    	   var id = document.createTextNode(object.id);
                    	   var name = document.createTextNode(object.name);
                    	   var rollnum = document.createTextNode(object.rollnum);
                    	   var age = document.createTextNode(object.age);
                    	   var std = document.createTextNode(object.std);
                    	   
                    	   idtd.appendChild(id);
                    	   nametd.appendChild(name);
                    	   rollnumtd.appendChild(rollnum);
                    	   agetd.appendChild(age);
                    	   stdtd.appendChild(std);
                    	   
                    	   row.appendChild(idtd);
                    	   row.appendChild(nametd);
                    	   row.appendChild(rollnumtd);
                    	   row.appendChild(agetd);
                    	   row.appendChild(stdtd);
                    	   
                    	   table.appendChild(row);
                	   }
                		   
                   }
                	   
           </script>
      </head>
      
      <body>
           
           <form name="form1"> 
                 <input type="text" name="id" placeholder="Student ID"> <br><br>
                 <input type="text" name="name" placeholder="Student Name"> <br><br>
                 <input type="text" name="rollnum" placeholder="Student Roll No"> <br><br>
                 <input type="text" name="age" placeholder="Student Age"> <br><br>
                 <input type="text" name="std" placeholder="Student Standard"> <br><br>
                 
                 <input type="button" value="Get" onclick="getdata()">
                 <input type="button" value="Post" onclick="postdata()">
                 <input type="button" value="Delete" onclick="deletedata()">
                 <input type="button" value="Update" onclick="updatedata()">
                 <input type="button" value="GetAll" onclick="getalldata()">
           </form>
           
           <table id="table1">
           
           </table>
      </body>



</html>