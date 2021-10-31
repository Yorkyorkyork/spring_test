// 設定 url
let url = "http://localhost:8080/api1/custo/login";

// --------------------------

// login 傳送資料
let btn_login_submit = document.getElementById("login_submit");

btn_login_submit.onclick = function () {
  let emailvalue = document.getElementById("login_email").value;
  let passwordvalue = document.getElementById("login_password").value;

  let JsonMember = JSON.stringify({
      email: emailvalue,
      password: passwordvalue,
      })
  /*const login_data = {};
  login_data.user_email = email;
  login_data.user_password = password;*/
  // console.log(login_data);
  //console.log(JSON.stringify(login_data));

  fetch(url, {
    method: "POST",
    body: JsonMember,
    headers: new Headers({
      "Content-Type": "application/json",
      'charset': 'UTF-8',
    })
  })
    .then((res) => res.json())
    .then(function (response) {
      console.log("Success:", response);
      if(response.code == 200){
        console.log("登入成功");
        location = response.data;
      };
      if(response.code == 400){
         alert("登入失敗：" + response.message);

        Swal.fire({
          icon: 'error',
          title: 'Oops! 登入失敗',
          text: response.message
        })
      };
      // console.log(response.src);
      // location = response.src;
      // return response;
    }).catch((error) => console.log("Error:", error));
};