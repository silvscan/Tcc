function closeDialog () {
	limparDadosLogin(true);
    $('#windowTitleDialog').modal('hide'); 
};

function limparDadosLogin(limparUsuario){
	if (limparUsuario){
		get('login_usuario').value = "";
	}
	get('login_senha').value = "";
}