let login_form = document.getElementById('login-validation');

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    alert(document.getElementById('id').value);
    if (login_form.checkValidity() === true) {
        let response = await fetch('api/Employees/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                id : document.getElementById('id').value,
            })
        });
        let result = await response;
        if(result["status"]===200){
            location.href = "dashboard.html";
    }else{
        document.getElementById("login-alert").style.display = "block";
    }
}})