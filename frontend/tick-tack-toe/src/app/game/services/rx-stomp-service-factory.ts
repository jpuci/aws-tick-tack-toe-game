import {RxStompService} from "./rx-stomp.service";
import {STOMP_CONFIG} from "../../rx-stomp.config";

export function RxStompServiceFactory(){
  const rxStomp = new RxStompService();
  rxStomp.configure(STOMP_CONFIG);
  rxStomp.activate();
  return rxStomp;
}
