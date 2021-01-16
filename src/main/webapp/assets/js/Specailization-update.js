let student_detail = document.getElementById('student_details');
var idx = localStorage.getItem('x')
//window.onload = Student_details;


document.getElementById('mybtn').addEventListener("click", Student_details);
async function Student_details(){
        let response = await fetch("api/students/id",{
            headers: {
        'Content-Type': 'application/json;charset=utf-8'
         },
    body: JSON.stringify({
        id : idx,
       })
        });
        try{
            let result = await response.json()
            console.log(result);
            document.getElementById('ID').innerText = result['id']
            document.getElementById('firstname').innerText = result['first_name']
            document.getElementById('lastname').innerText = response['last_name']
            document.getElementById('email').innerText = response['email']
            document.getElementById('Roll_NUMBER').innerText = response['roll_number']


        }
        catch(e){
            //no json object
        }
        //let courses = await response.json(); // read response body and parse as JSON
        let response1 = await fetch("api/students/getspecialisation",{
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id : idx,
        })
    });
        try {
            let result1 = await response1.json()
            console.log(result1);
            document.getElementById('Specailization').innerText = result1['name']
        }
        catch(e){
            //no json object
        }
    }