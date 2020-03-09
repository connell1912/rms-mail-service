import axios from 'axios';
import React, { SyntheticEvent } from "react";
import { Form } from 'reactstrap';


interface IChangePasswordState {
  username: string;
  newPassword: string,
  }

  interface  IChangePasswordProp {
    newPassword: string,
  }

  export class changePasswordComponent extends React.Component<any, IChangePasswordState> {
    constructor(props: any) {
      super(props);
      this.state = {
        username: "",
        newPassword: ""
      };
      
    }

    async componentDidMount () {
      await axios.post('http://localhost:8080/employee/old')
      .then (response => {
        console.log(response);
        if (response.data.message === 'password reset link' ){
          this.setState({
            username: response.data.username,
            newPassword:response.data.password
          });
        } else {
          this.setState({
            username: '',
            newPassword: ''
          });
        }
      })
    }

    //  handleChange = (username:string, newPassword: string) => (event:any) => {
    //   this.setState ({
    //     [username]: event.target.value,
    //     [newPassword]: event.target.value
    //   });
    // }

    updateUsername = (event: any) => {
      this.setState({
        ...this.state,
        username: event.target.value
      });
    };

    updatePassword = (event: any) => {
        this.setState({
          ...this.state,
          newPassword: event.target.value
        });
      };

      changePassword = async (event: SyntheticEvent) => {
        event.preventDefault();
        apiChangePassword(
          this.state.newPassword
        );
    
        this.props.history.push("/login");
      };

      render() {
        return (
            <div>
                 <h1>Reset Your Password Here</h1>
                 <Form onSubmit={this.changePassword}>
                 <p>username</p>
                   <input type="text" onChange = {this.updateUsername} value={this.state.username}/>
                 <p>new password</p>
                   <input type="password" onChange = {this.updatePassword} value={this.state.newPassword}/>    
                   <p>confirm new password</p>
                   <input type="password" onChange = {this.updatePassword}/>                 
                 </Form>
            </div>
        )
    }

}
    