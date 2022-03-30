import React, {Component} from "react";
import { BrowserRouter } from "react-router-dom";
import {Switch, withRouter} from "react-router";

import Write from "../Board/Write";
import BoardMain from "../Board/BoardMain";
import Detail from "../Board/Detail";
import BoardMain from "./src/Board/BoardMain";
import Delete from "./src/Board/Delete";

class DefaultApp extends Component {
    render() {
        const HeaderWithRouter = withRouter(Header);

        return (
            <Router>
                <HeaderWithRouter/>
                <main id ="main">
                    <Switch>
                        <Route path="/board-write" exact component={Write} />
                        <Route path="/BoardMain" exact component={BoardMain} />
                        <Route path="/board-detail" exact component={Detail} />
                        <Route path="/board-delete" exact component={Delete} />
                    </Switch>
                </main>
            </Router>
        )
    }
}

export default DefaultApp;