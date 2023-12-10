// import { Injectable } from '@angular/core';
// import { RxStomp } from '@stomp/rx-stomp';
// import {rxStompServiceFactory} from "./rx-stomp-service-factory";
//
// @Injectable({
//   providedIn: 'root',
//   useFactory: rxStompServiceFactory
// })
// export class RxStompService extends RxStomp {
//   constructor() {
//     super();
//   }
// }

// import {Injectable} from '@angular/core';
// import {RxStomp} from "@stomp/rx-stomp";
// import {StompFactory} from "../../utility/stomp-factory";

import {Injectable} from "@angular/core";
// import {StompFactory} from "./rx-stomp-service-factory";
import {RxStomp} from "@stomp/rx-stomp";
import {RxStompServiceFactory} from "./rx-stomp-service-factory";

@Injectable({
  providedIn: 'root',
  useFactory: RxStompServiceFactory
})
export class RxStompService extends RxStomp {
}
