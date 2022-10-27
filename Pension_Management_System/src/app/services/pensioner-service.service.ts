import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PensionerDetails } from '../Details/PensionerDetails';

@Injectable({
  providedIn: 'root'
})
export class PensionerServiceService {

  baseURL = "http://localhost:8061/api/details"
  pension_disbursement_URL = "http://localhost:8070/api/portal"
  // baseURL ="http://pms-microservices-lb-1484324810.us-east-1.elb.amazonaws.com/api/details"
  // pension_disbursement_URL="http://pms-microservices-lb-1484324810.us-east-1.elb.amazonaws.com/api/portal"
  constructor(private http:HttpClient) { }

  getPensionerList(){
    return this.http.get(`${this.baseURL}/allDetails`);
  }


  getPensionerById(aadharNumber:string){
    // console.log(this.aadharNumber);

    return this.http.get(`${this.baseURL}/pensionerList/${aadharNumber}`);
  }

  update(aadharNumber:string,pensionerDetails:PensionerDetails){
    return this.http.put(`${this.baseURL}/${aadharNumber}`,pensionerDetails);
  }

  deletePensioner(aadharNumber:string){
    return this.http.delete(`${this.baseURL}/pensionerList/${aadharNumber}`);
  }


  getPensionDetail(credentials:any)
  {
    return this.http.post( `${this.pension_disbursement_URL}/pensionDetail`,credentials);
  }

  processPension(credentials:any)
  {
    return this.http.post(`${this.pension_disbursement_URL}/processPension`,credentials);
  }
}
