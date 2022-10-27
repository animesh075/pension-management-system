import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { PensionerServiceService } from 'src/app/services/pensioner-service.service';

@Component({
  selector: 'app-pensioner-details',
  templateUrl: './pensioner-details.component.html',
  styleUrls: ['./pensioner-details.component.css']
})
export class PensionerDetailsComponent implements OnInit {

  aadharNumber!: string;
  pensionerList:any=[{
    aadharNumber:"",
    name:"",
    dateOfBirth:"",
    panNumber:"",
    salary:null,
    allowance:null,
    pensionType:"",
  }];

  constructor(private pensionService: PensionerServiceService,private route: ActivatedRoute,private router:Router) { }


  ngOnInit(): void {

    this.getPensioner();
    this.aadharNumber = this.route.snapshot.params['aadharNumber'];
    this.pensionService.getPensionerById(this.aadharNumber).subscribe(data=>{
      this.pensionerList=data;
    })

  }
  private getPensioner(){
    this.pensionService.getPensionerById(this.pensionerList.aadharNumber).subscribe(data=>{
      this.pensionerList = data;
      console.log(data);

    })
  }
  // updatePensioner(aadharNumber:String){
  //   this.router.navigate(['pensioner-update',aadharNumber])
  // }
  calculatePensioner(aadharNumber:string){
    this.router.navigate(['calculate-pension',aadharNumber])
  }
  goBack(){
    this.router.navigate(['pensioner-lists']);
  }
}
