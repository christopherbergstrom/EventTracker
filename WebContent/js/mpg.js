window.onload = function()
{
  popSelect();
  init();
  console.log("start");

}
// var table = document.table;
function popSelect()
{
  optionID(option);
}
function init()
{
  var form = document.get;
	form.submit.addEventListener("click", function (e)
	{
  	e.preventDefault();
  	requestdata(name);
	});

  var getID = document.getID;
  getID.submit.addEventListener("click", function (e)
	{
  	e.preventDefault();
  	requestID(nameId);
	});

  var updateID = document.updateID;
  updateID.submit.addEventListener("click", function (e)
	{
    e.preventDefault();
    var desc = document.updateID.desc.value;
    var miles = document.updateID.miles.value;
    var gallons = document.updateID.gallons.value;
    var gas = document.updateID.gas.value;
    var input = document.updateID.select.value;
    var obj = {"tripDescription":desc, "milesDriven":miles, "gallonsPurchased":gallons, "priceOfGas":gas};
  	updateData("POST", "http://localhost:8080/MPGTracker/rest/mpg/" + input, obj);
    // method, url, object, callback
	});

  var deleteID = document.deleteID;
  deleteID.submit.addEventListener("click", function (e)
	{
    e.preventDefault();
    var input = document.deleteID.select.value;
    var obj = {"id":input};
  	updateData("DELETE", "http://localhost:8080/MPGTracker/rest/mpg/" + input, obj);
    // method, url, object, callback
	});

  var add = document.add;
  add.submit.addEventListener("click", function (e)
	{
    e.preventDefault();
    var desc = document.add.desc.value;
    var miles = document.add.miles.value;
    var gallons = document.add.gallons.value;
    var gas = document.add.gas.value;
    // console.log(desc);
    // console.log(miles);
    // console.log(gallons);
    // console.log(gas);
    var obj = {"tripDescription":desc, "milesDriven":miles, "gallonsPurchased":gallons, "priceOfGas":gas};
    // console.log("PUT", "http://localhost:8080/MPGTracker/rest/mpg", obj);
    // popSelect();
  	updateData("PUT", "http://localhost:8080/MPGTracker/rest/mpg", obj);
	});
  // clearTable();
}

var requestdata = function(callback)
{
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "http://localhost:8080/MPGTracker/rest/getData");
  xhr.onreadystatechange = function()
  {
    if (xhr.readyState == 4 && xhr.status < 400 )
    {
      var array = JSON.parse(xhr.responseText);
      callback(array);
    }
  };
  xhr.send(null);
};

var requestID = function(callback)
{
  var input = document.getID.select.value;
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "http://localhost:8080/MPGTracker/rest/getData/" + input);
  xhr.onreadystatechange = function()
  {
    if (xhr.readyState == 4 && xhr.status < 400 )
    {
      var array = JSON.parse(xhr.responseText);
      callback(array);
    }
  };
  xhr.send(null);
};

var optionID = function(callback)
{
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "http://localhost:8080/MPGTracker/rest/getData/");
  xhr.onreadystatechange = function()
  {
    if (xhr.readyState == 4 && xhr.status < 400 )
    {
      var array = JSON.parse(xhr.responseText);
      callback(array);
    }
  };
  xhr.send(null);
};

// function name(array)
// {
//   var body = document.querySelector("body");
//   for (var i = 0; i < array.length; i++)
//   {
// 		var p = document.createElement("p");
// 		p.value = array[i].tripDescription;
// 		p.innerHTML = array[i].tripDescription;
// 		body.appendChild(p);
//   }
// }

function option(array)
{
  var select = document.getID.querySelector("select");
  var selectU = document.updateID.querySelector("select");
  var selectD = document.deleteID.querySelector("select");
  for (var j = 0; j < 3; j++)
  {
    for (var i = 0; i < array.length; i++)
    {
    // var obj = array[i]
    // for (var p in obj)
    // {
    // }
      var option = document.createElement("option");
      option.value = array[i].id;
      option.innerHTML = array[i].id;
      if (j===0)
      {
        select.appendChild(option);
      }
      else if (j===1)
      {
        selectU.appendChild(option);
      }
      else
      {
        selectD.appendChild(option);
      }
    }
  }
}

function name(array)
{
  var body = document.querySelector("body");
  var table = document.createElement("table");
  table.setAttribute("id", "table");

  for (var i = 0; i < array.length; i++)
  {
    var tr = document.createElement("tr");
    var key = array[i]
    for (var k in key)
    {
      var th = document.createElement("th");
      th.setAttribute("id", "th");
      th.value = k;
      th.innerHTML = k;
      tr.appendChild(th);
      table.appendChild(tr);
    }
    var tr = document.createElement("tr");
    var obj = array[i]
    for (var p in obj)
    {
      var td = document.createElement("td");
      td.setAttribute("id", "td");
      td.value = obj[p];
      td.innerHTML = obj[p];
      console.log(obj[p]);
      tr.appendChild(td);
      table.appendChild(tr);
    }
    // var td = document.createElement("td");
  }
  body.appendChild(table);
}

function nameId(array)
{
  var body = document.querySelector("body");
  var table = document.createElement("table");
  table.setAttribute("id", "table");
    var tr = document.createElement("tr");
    var key = array
    for (var k in key)
    {
      var th = document.createElement("th");
      th.setAttribute("id", "th");
      th.value = k;
      th.innerHTML = k;
      tr.appendChild(th);
      table.appendChild(tr);
    }
    var tr = document.createElement("tr");
    var obj = array
    for (var p in obj)
    {
      var td = document.createElement("td");
      td.setAttribute("id", "td");
      td.value = obj[p];
      td.innerHTML = obj[p];
      tr.appendChild(td);
      table.appendChild(tr);
    }
  body.appendChild(table);
}
// function clearTable(table)
// {
// 	table.parentNode.removeChild(table);
// }
function updateData(method, url, object, callback)
{
    var xhr = new XMLHttpRequest();
    xhr.open(method,url);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange=function ()
    {
        // console.log(xhr.status);
        // console.log(xhr.readyState);
        // console.log(xhr.responseText);
        // console.log(xhr.getAllResponseHeaders());

    }
    if (object)
    {
        xhr.send(JSON.stringify(object));
    }
    else
    {
        xhr.send(null);
    }
    // popSelect();
}
