import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { HomePage } from "../home/home";

@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {
  userName: string;
  password: string;

  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
  }

  ionViewDidLoad() {
  }

  login() {
    if (this.userName && this.password) {
      this.navCtrl.push(HomePage);
    } else {
      let alert = this.alertCtrl.create({
        title: 'Notice !',
        subTitle: 'Username and password should not be empty !',
        buttons: ['OK']
      });
      alert.present();
    }
  }

}
