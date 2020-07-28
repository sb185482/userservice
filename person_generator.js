/*
Purpose of this script is to generate the Java code needed to add initial users to Datanauts UserService Application
Steps to use (Chrome):
	GoTo: https://api.namefake.com/
	Open up the Chrome Developer console
	GoTo: Snippets
	Create  a new snipper (called PersonGenerator)
	Copy and Paste in the code below
	Copy the output from the Chrome console into the static block of UserDao.java
	Rename the UserID (first parameter as needed)
*/
var xmlhttp = new XMLHttpRequest();
xmlhttp.open('GET', 'https://api.namefake.com/', true);
xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4) {
        if(xmlhttp.status == 200) {
            var person = JSON.parse(xmlhttp.responseText);
            //console.log(person);
            let name = person.name;
            let email = person.email_u + '@gmail.com';
            let address = person.address.replace(/(\r\n|\n|\r)/gm," ");
            let accountNo = Math.floor(Math.random()*90000) + 1000000;
            let phoneNumber = Math.floor(Math.random()*90000) + 1000000000;

            console.log(
                `list.getUserList().add(new User(1, "${name}", "${email}", "${address}","${phoneNumber}", "${accountNo}"));`
            );
         }
    }
};
xmlhttp.send(null);