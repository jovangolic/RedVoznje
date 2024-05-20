function validirajFormu(){
	//pristupanje elementima forme
	let redni_broj = document.getElementById("redni_broj");
	let polaziste = document.getElementById("polaziste");
	let odrediste = document.getElementById("odrediste");
	let gradski = document.getElementById("gradski");
	
	//provera da li su sva polja uneta
	if(redni_broj == "" || polaziste == "" || odrediste == "" || gradski == null){
		alert("Polja moraju biti popunjena.");
		return;
	}
	
	//unos broja za trajanje koji se pretvara u string
	let broj = parseInt(redni_broj.value);
	if(isNaN(broj) || broj <= 0){
		alert("Redni broj ne sme biti manji ili jednak nuli!");
		return;
	}
	
	if(polaziste === odrediste){
		alert("Polaziste i odrediste ne smeju biti iste vrednosti");
		return;
	}
	
	document.getElementById("mojaForma").submit();
}

validirajFormu();