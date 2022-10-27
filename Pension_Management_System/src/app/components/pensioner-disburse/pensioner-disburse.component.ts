import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PensionerServiceService } from 'src/app/services/pensioner-service.service';
import  Swal  from 'sweetalert2';

@Component({
  selector: 'app-pensioner-disburse',
  templateUrl: './pensioner-disburse.component.html',
  styleUrls: ['./pensioner-disburse.component.css']
})
export class PensionerDisburseComponent implements OnInit {

  credentials={
    aadharNumber:'',
    pensionAmount:null,
    serviceCharge:null,
  }
  result:any;
  bankName = ''
  serviceCharge :any

  ProcessCode : any;
  constructor(private pensionService:PensionerServiceService,private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  onSubmit()
  {
    this.pensionService.processPension(this.credentials).subscribe(
      (data:any)=>
      {
        console.log(data);

        this.result=Object.values(data);

        if(this.result==10)
        {
          // this._snackBar.open("Pension Disbursed Successfully!!!",'',{
          //   duration:3000,

          // })
          Swal.fire('Success', 'Pension Disbursed Successfully!!!','success');
          console.log("Success");


        }
        if(this.result==21)
        {
          // this._snackBar.open('Pension cannot be Disbursed!!!', '',{
          //   duration:3000,
          // })

          Swal.fire('Not Successful!!!', 'Pension cannot be Disbursed!!!','error');
          console.log("Error");

        }
      },
      error=>
      {
        console.log(error);
        // this._snackBar.open('Enter Valid Details!!!', '',{
        //   duration:3000,
        // })
        Swal.fire('Not Successful!!!', 'Enter Valid Details!!!','error');
      }
    );
  }

}
