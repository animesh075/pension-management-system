import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PensionerServiceService } from 'src/app/services/pensioner-service.service';

@Component({
  selector: 'app-pensioner-list',
  templateUrl: './pensioner-list.component.html',
  styleUrls: ['./pensioner-list.component.css']
})
export class PensionerListComponent implements OnInit {

  aadharNumber:any;
  pensionerList:any=[{
    aadharNumber:"",
    name:"",
    dateOfBirth:"",
    panNumber:"",
    salary:null,
    allowance:null,
    pensionType:"",
    bankName:""
  }];
p:number=1;

  constructor(private pensionService:PensionerServiceService,private router:Router) { }

  ngOnInit(): void {
    this.getPensioner();
  }
  private getPensioner() {
    this.pensionService.getPensionerList().subscribe(data=>{
      this.pensionerList=data;
    })
  }

  pensionerDetails(aadharNumber:string){
    console.log(aadharNumber);
    this.router.navigate(['pensioner-details',aadharNumber])
  }

  deletePensioner(aadharNumber:string){
    this.pensionService.deletePensioner(aadharNumber).subscribe((data:any)=>{
      console.log(data);
      this.getPensioner();
    })
  }
  Search(){
    if(this.aadharNumber == ""){
      this.ngOnInit();

    }
    else{
      this.pensionerList = this.pensionerList.filter((res:any)=>{
        return res.aadharNumber.toLocaleLowerCase().match(this.aadharNumber.toLocaleLowerCase());
      })
    }
  }

}
