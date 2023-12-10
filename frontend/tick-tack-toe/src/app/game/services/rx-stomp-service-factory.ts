// import { RxStompService } from './rx-stomp.service';
// import {myRxStompConfig} from "../../my-rx-stomp.config";
//
// export function rxStompServiceFactory() {
//   const rxStomp = new RxStompService();
//   rxStomp.configure(myRxStompConfig);
//   rxStomp.activate();
//   return rxStomp;
// }
//
// import {STOMP_CONFIG} from "../config/rx-stomp-config";
// import {RxStompService} from "../service/rx-stomp-service/rx-stomp.service";

import {RxStompService} from "./rx-stomp.service";
import {STOMP_CONFIG} from "../../rx-stomp.config";

export function RxStompServiceFactory(){
  const rxStomp = new RxStompService();
  rxStomp.configure(STOMP_CONFIG);
  rxStomp.activate();
  return rxStomp;
}
