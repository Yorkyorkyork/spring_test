// 設定 url
//let url = "http://localhost:8080/api/cus/add";

// --------------------------
// 前端輸入註冊資料判斷
// email 判斷
const emailReg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
let email = document.getElementById("signup_email");
let email_input_info = document.getElementById("email_input_info");
email.oninput = function () {
  // console.log(email.value);
  if (emailReg.test(email.value)) {
    email_input_info.innerText = "";
  } else {
    email_input_info.innerText = "請輸入合法的 Email";
  }
};

// password 判斷
const passwordReg = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
let signup_password = document.getElementById("signup_password");
signup_password.oninput = function () {
  let password_input_info = document.getElementById("password_input_info");
  if (passwordReg.test(signup_password.value)) {
    password_input_info.innerText = "";
  } else {
    password_input_info.innerText = "請輸入至少8位的數字與英文密碼";
  }
};

// password 確認 判斷
let signup_confirm_password = document.getElementById(
  "signup_confirm_password"
);
signup_confirm_password.oninput = function () {
  let confirm_password_input_info = document.getElementById(
    "confirm_password_input_info"
  );

  if (signup_confirm_password.value === signup_password.value) {
    confirm_password_input_info.innerText = "";
  } else {
    confirm_password_input_info.innerText = "密碼不符...";
  }
};

// phone 判斷
const PhoneReg = /^09[0-9]{8}$/;
let user_phone_number = document.getElementById("user_phone_number");
let phone_input_info = document.getElementById("phone_input_info");
user_phone_number.oninput = function () {
  if (PhoneReg.test(user_phone_number.value)) {
    phone_input_info.innerText = "";
  } else {
    phone_input_info.innerText = "請輸入正確的手機號碼(台灣)";
  }
};

// ----------------------
// signup 資料傳送

let btn_signup_submit = document.getElementById("signup_submit");

btn_signup_submit.onclick = function () {
  let emailvalue = document.getElementById("signup_email").value;
  let passwordvalue = document.getElementById("signup_password").value;
  let userNamevalue = document.getElementById("username").value;
  let phonevalue = document.getElementById("user_phone_number").value;
  
  let JsonMember = JSON.stringify({
      email: emailvalue,
      password: passwordvalue,
      nickName: userNamevalue,
      phone: phonevalue
     })
  /*const signup_data = {};
  signup_data.user_mail = email;
  signup_data.user_password = password;
  signup_data.user_name = userName;
  signup_data.user_phone = phone;*/
  // console.log(signup_data);

  fetch('http://localhost:8080/api1/custo/signUp', 
  	{
    method: "POST",
    body: JsonMember,
    headers: new Headers({
             'Content-Type': 'application/json',
             'charset': 'UTF-8',   
             })
  })
    .then((res) => res.text())
    .then(function (response) {
		console.log("Success:", response.data);
	 if(response.code === 400){
		alert(response.message);
	 }
	
		//window.location.href = response.data;
		
    }) .catch((error) => console.log("Error:", error));/*
    .then(function (response) {
         console.log(response.src);
      location = response.src;
    });*/
};
