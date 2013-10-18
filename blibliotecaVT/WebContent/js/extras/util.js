function get(id){
	return document.getElementById(id);
}

function getByName(name){
	return document.getElementsByName(name);
}

function getByclass(className){
	var hasClassName = new RegExp("(?:^|\\s)" + className + "(?:$|\\s)");
	var allElements = document.getElementsByTagName("*");
	var results = [];
	
	var element;
	for (var i=0; (element = allElements[i]) != null; i++){
		var elementClass = element.className;
		if(elementClass && elementClass.indexOf(className) != -1 && hasClassName.test(elementClass)){
			results.push(element);
		}
	}
	return results;
}

function somenteNumeros(v){
	return v.replace(/\D/g, "");
}

function somenteLetras(v){
	return v.replace(/\d/g, "");
}

function somenteNumeros_letras(v){
	return v.replace(/[^\w\s]/gi, "");
}

/*
 * função para limitar a quantidade de caracteres.
 */
function limitaTexto(campo, marcador){
	v = campo.value;
	v = v.substring(0,500);
	get(marcador).innerText = v.length;
	return v;
}

function converterNumeroDecimal(valor){
	var v = somenteNumeros(valor);
	v = v.replace(/(\d{1})(\d{1,2})$/,"$1.$2");
	v = parseFloat(v,10).toFixed(2);
	return v;
}

function converterNumeroInteiro(valor) {
	var v = somenteNumeros(valor);
	v = parseInt(v, 10);
	return v;
}

function mascaraData(campoData){
    var data = campoData.value;
    if (data.length == 2){
        data = data + '/';
        campoData.value = data;
return true;              
    }
    if (data.length == 5){
        data = data + '/';
        campoData.value = data;
        return true;
    }
}
