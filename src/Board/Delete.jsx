import { Component } from "react"
import axios from 'axios';

class Delete extends Component {
    constructor(props) {
        super(props);
        this.state = {
            
        }
    }

    deleteInfo(id) {
        const deleteId = this.state.deleteID;
        alert(deleteId)
        console.log("삭제할 아이디", deleteID);

        axios.delete(`/api/board-info/${deleteId}`)
        .then(res => {
            console.log(res);
        })
    }

    render() {
        return(
            <>
            삭제됨
            </>
        );
    }
}

export default Delete;