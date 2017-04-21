import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {JournalComponent} from './journal/journal.component';
import {JournalService} from "./journal/journal.service";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {HttpService} from "./common/http.service";

@NgModule({
  declarations: [
    AppComponent,
    JournalComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule.forRoot()
  ],
  providers: [JournalService, HttpService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
