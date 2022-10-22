import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
})
export class CardComponent implements OnInit {
  cardData = {
    cardNumber: '',
    cardYear: '',
    cardMonth: '',
    cardCVV: '',
  };

  constructor(
    private _router: Router,
  ) {}

  ngOnInit(): void {}

  formSubmit() {
    if (
      this.cardData.cardNumber == '1234123412341234' &&
      this.cardData.cardMonth == '08' &&
      this.cardData.cardYear == '2022' &&
      this.cardData.cardCVV == '123'
    ) {
      Swal.fire('Success', 'Payment Confirm', 'success');
      
      this._router.navigate(['/user-dashboard/0']);
    } else if (
      this.cardData.cardNumber != '1234123412341234' ||
      this.cardData.cardYear != '2022' ||
      this.cardData.cardMonth != '08' ||
      this.cardData.cardCVV != '123'
    ) {
      Swal.fire('Error', 'Payment Failed', 'error');
      
    }
  }
}
