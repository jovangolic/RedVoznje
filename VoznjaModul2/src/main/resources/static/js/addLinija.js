//zadatak 7 Koriscenje AJAX i JS-a.
document.getElementById("dodajLiniju").addEventListener("submit", function(event){
	
	event.preventDefault();
	let formData = new FormData(this);
	
	//ajax zahtev
	let xhr = new XMLHttpRequest();
	xhr.open("post","/Test/Linije/Create");
	xhr.onload = function(){
		if(xhr.status === 200){
			alert("Linija je uspesno dodata.");
		}
		else{
			alert("Doslo je do greske.");
		}
	}
	xhr.send(formData);
});
