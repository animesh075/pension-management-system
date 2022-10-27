import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { PensionDetail } from 'src/app/Details/PensionDetail';
import { PensionerServiceService } from 'src/app/services/pensioner-service.service';

@Component({
  selector: 'app-calculate-pension',
  templateUrl: './calculate-pension.component.html',
  styleUrls: ['./calculate-pension.component.css']
})
export class CalculatePensionComponent implements OnInit {

  credentials={
    name:"",
    dateOfBirth:"",
    panNumber:"",
    aadharNumber:"",
    pensionType:""
  }
  result:any;
  id!:string;
  pension:PensionDetail[]=[];

  constructor(private pensionService:PensionerServiceService,private route: ActivatedRoute,private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['aadharNumber'];
    this.pensionService.getPensionerById(this.id).subscribe((data:any)=>{this.credentials=data;},error=>console.log(error))
  }
  onSubmit()
  {


    this.pensionService.getPensionDetail(this.credentials).subscribe(
      (pensiondetail:any)=>
      {
        this.pension.push(pensiondetail);
        console.log(pensiondetail);
        this._snackBar.open('Please Wait For a Moment, We are Processing!!!', '',{
          duration:3000,
        })

      },
      error=>
      {
        console.log(this.credentials);
        console.log(error);
        this._snackBar.open('Invalid User!!!', '',{
          duration:3000,
        })

      }
    );

  }

}
