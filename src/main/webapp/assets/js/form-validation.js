let student_form = document.getElementById('student-validation');


student_form.addEventListener('submit', async (e) => {
  e.preventDefault();
  e.stopPropagation();
  if (student_form.checkValidity() === true) {
      localStorage.setItem('x',document.getElementById('id').value)

      let response = await fetch('api/students/login', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify({
          id : document.getElementById('id').value,

      })

    });
      let result = await response;
      if(response["status"] === 200){
        let response = await fetch('api/students/updatedspecailisation', {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json;charset=utf-8'
          },
          body: JSON.stringify({
            id : document.getElementById('id').value,

          })
        });
        let result = await response;
        console.log(result)
        if(result["status"] === 200 ){
            location.href = "output.html";

        }
      }else{
        document.getElementById("login-alert").style.display = "block";
      }
  }
}
)
