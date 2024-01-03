
import {Injectable} from "@angular/core";

import {RxStomp} from "@stomp/rx-stomp";
import {RxStompServiceFactory} from "./rx-stomp-service-factory";

@Injectable({
  providedIn: 'root',
  useFactory: RxStompServiceFactory
})
export class RxStompService extends RxStomp {
}
