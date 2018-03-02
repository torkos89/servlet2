
var e = document.getElementById("into");	// tbody element
var t = document.getElementById("things");	// form element
t.onsubmit = function(ev){	// trigger event when form submits
	ev.preventDefault()	// prevent the link from following the URL 
	//create(t.children[0].value,t.children[1].value)
  send(t.children[0].value,t.children[1].value,create) // form children values & create()
  t.children[0].value = ""	// clear Store in form id things
  t.children[1].value = "" // clear Item in form id things
  t.children[0].focus()	// set cursor to first text field
} 
function edit(i){
	alert(i);
}
function rem(i){
	// ex: i=0
	document.getElementById(i).remove();
	
	//TODO: remove line item from servlet
}
//var func = create = function(bits){
function create(bits){ // bits: array of arrays
	e.innerHTML = ""; // resets per call
	for(let i=0;i<bits.length;i++){  // loop through tbody
		e.innerHTML += "<tr id="+i+"><td>"+bits[i][0]+"</td><td>"+bits[i][1]
		 +"</td><td><div hidden id='edit' onclick="+"edit"+'('+i+')'+"><i class='fas fa-pencil-alt fa-fw'></i></div></td>"
		 +	"</td><td><div hidden id='remove' onclick="+"rem"+'('+i+')'+"><i class='fas fa-times-circle'></i></div></td></tr>"
		// TODO: edit and remove td's
	}
}
function send(store,item,func){
	let aj = new XMLHttpRequest();	// update,request,receive,send
	aj.onreadystatechange = function(){  // calls function on change
		if(aj.readyState==XMLHttpRequest.DONE){  // when state is done
			if(aj.status==200){ // 200:succsess
				func(JSON.parse(aj.responseText)) // create( JSON object ) formated responseText
			}
		}
	}
	if(store){ // if true
		aj.open("post","addItemServlet") // save a copy and spits data
		aj.setRequestHeader("Content-type","application/x-www-form-urlencoded") // execute as form
		aj.send("store="+store+"&item="+item) // format and send
	}
	else{  // if false
		aj.open("get","addItemServlet")	// spits data
		aj.send()	// send nothing
	}
}
send(false,false,create)	 // on load triggers "get" and spits data if available