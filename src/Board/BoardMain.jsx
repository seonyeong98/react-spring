import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import axios from 'axios'

class BoardMain extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            deleteId:''
        }
    }

    componentDidMount() {
        this.getList();
    }

    getList() {
        axios.get(`/api/board-info`)
        .then(res => {
            this.setState({
                items: res.data
            })
        })
    }

    //데이터 삭제 함수
    deleteUser = (deleteId) => {
        axios.delete(`/api/board-info/delete/${deleteId}`)
        .then(res => {
            console.log(res);
            this.getList();
        })
    }

    search = () => {
        const keyword = this.state.search;
        console.log("search event", keyword)
        axios.get(`/api/board-info/search?keyword=${keyword}`)
        .then(res => {
            console.log(res);
            this.setState({
                items: res.data
            })
        })
    }

    searchSpace = async(event) => {
        let keyword = event.target.value;
        await this.setState({
            search: keyword
        });
    }

    render(){
        return(
            <>
            <form>
                <div className='search-body'>
                    <input type = "text" onChange = {this.searchSpace}/>
                    <button type = "button" onClick={this.search}>검색</button>
                </div>
            </form>
            <br/>
            <ul>
                {items.map((items) => (
                    <li key = {items.id}>
                        {items.id}&nbsp;
                        {items.name}&nbsp;
                        {items.address}&nbsp;
                        {items.email}&nbsp;
                        <button type='button' onClick={() => this.deleteUser(items.id)}>삭제</button>
                    </li>
                ))}
            </ul>
            <br/>
            <Link to ="/board-write">등록</Link>
            </>
        )
    }
}

export default BoardMain; 