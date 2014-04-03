function exibeCod(tag){
	if (tag.id == "formCTCC:orientadorCT"){
		get("formCTCC:codOrientadorCT").value = tag.value;
	} else {
		get("formCTCC:raAlunoCT").value = tag.value;
	}
}

$(document).ready(function(){
	$(get("frmCadastroAlu:dataNascimentoAlu")).mask("99/99/9999");
	$(get("frmCadastroProf:dataNascimentoOri")).mask("99/99/9999");
	$(get("formCTCC:dataConclusao")).mask("99/99/9999");
	$(get("frmCadastroAlu:cpfAlunoCad")).mask("999.999.999-99");
	$(get("frmCadastroProf:cpfOrientadorCad")).mask("999.999.999-99");
	$(get("formCTCC:cpfOrientadorTB")).mask("999.999.999-99");
	$(get("formCTCC:cpfAlunoTB")).mask("999.999.999-99");
});