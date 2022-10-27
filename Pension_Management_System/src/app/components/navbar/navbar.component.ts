import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn=false;
  // user=null;

  constructor(public login:LoginService,private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();

  }
  public logout(){
    this.login.logout();
    this.isLoggedIn = false;
    window.location.reload();
    window.location.href="/login";
    this._snackBar.open('Logging out!!!', '',{
      duration:3000,
    })
  }

}
