import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {JournalComponent} from './journal/journal.component';
import {HttpModule} from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    JournalComponent
  ],
  imports: [
    HttpModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
