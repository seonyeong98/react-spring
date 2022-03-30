import axios from 'axios'
import React, {Component} from 'react';

class Write extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: null,
            address: null,
            email: null
        }
    }

    createUser = () => {
        axios.post("/api/board-info/example",
        {
            name: this.state.name,
            address: this.state.address,
            email: this.state.email
        }).then(res => {
            console.log(res.data)
        })
    }

    handleInput = (e) => {
        const name = e.target.name;
        const value = e.target.value;

        console.log(name, value);
        this.setState({
            [name]: value
        });
    }

    render() {
        return(
            <>
            <div>
                이름: <input type = "text" id ="name" name = 'name' value = {this.state.name}onChange = {this.handleInput}/>
                주소: <input type = "text" id = "address" name = "address" value = {this.state.address}onChange = {this.handleInput}/>
                이메일: <input type = 'text' id ='email' name='email' value = {this.state.email}onChange = {this.handleInput}/>
            </div>
            <br/>
            <button type = 'button' onClick={this.createUser}>저장</button>
            </>
        )
    }
}

export default Write;