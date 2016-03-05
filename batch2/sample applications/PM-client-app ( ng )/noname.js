/**
 * http://usejsdoc.org/
 */


var json='[{"name":"Nag"},{"name":"Riya"}]';

var array=JSON.parse(json);
array.forEach(function(elt, i) {
	console.log(elt);
});