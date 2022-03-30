import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

class Detail extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            name: null,
            address: null,
            email: null,
            detailInfo:{}
        }
    }

    componentDidMount() {
        this.getListDetail();
    }

    getListDetail() {
        const boardId = this.state.boardId;
        console.log("아이디", boardId);
        axios.get(`api/board-info/${boardId}`)
        .then(res => {
            console.log(res);
            this.state({
                detailInfo: res.data
            })
        });
    }

    render() {
        const{items, detailInfo} = this.state;
        console.log(detailInfo)
        return(
            <>
            이름: {detailInfo.name}
            주소: {detailInfo.address}
            이메일: {detailInfo.email}
            </>
        );
    }

}

export default Detail;