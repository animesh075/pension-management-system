import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData={
    id:'',
    username:'',
    password:''
  };

  constructor(private login : LoginService, private router:Router,private _snackBar: MatSnackBar) { }

  ngOnInit(): void {

  }

  formSubmit(){
    console.log("form submitted");
    if((this.loginData.id.trim()=='' || this.loginData.id==null) &&
    (this.loginData.username.trim()=='' || this.loginData.username==null) &&
    (this.loginData.password.trim()=='' || this.loginData.password==null)){
      this._snackBar.open("User Name is Required!!!",'',{
        duration:3000,

      })
      console.log("Error")
    }
    else{

      this.login.generateToken(this.loginData).subscribe((data:any)=>{
        this._snackBar.open('Login Successful!!!', '',{
          duration:3000,
        })
        console.log("Success");
        console.log(data);
        console.log(data.authToken);
        console.log(data.id);
        this.login.loginUser(data.authToken,data.userid);
        window.location.href="/home";
        // this.router.navigate(['/home']);

      },(error)=>{
        console.log(error);

        console.log("Error!!!");
        this._snackBar.open('Invalid Credentials!!!', '',{
          duration:3000,
        })

      })
    }
  }
  reset(form:NgForm){
    form.resetForm()
  }

}
