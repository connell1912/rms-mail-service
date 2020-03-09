import React, { SyntheticEvent } from "react";
import { Link } from "react-router-dom";
import { apiRequestNewPassword } from "../api/requestNewPassword";

interface IRequestState {
  email: string;
}

interface IRequestProps {
    message: string;
  }


export class passwordResetRequestComponent extends React.Component<any, IRequestState> {
  constructor(props: any) {
    super(props);
    this.state = {
      email: ""
    };
    
  }

  updateEmail = (event: any) => {
    this.setState({
      ...this.state,
      email: event.target.value
    });
  };


  requestNewPassword = async (event: SyntheticEvent) => {
    event.preventDefault();
    apiRequestNewPassword(
      this.state.email
    );

    this.props.history.push("login");
  };

  render() {
    return (
      <div id="body">
        <div className="newPasswordRequest">
          <div>
           
            Email:
            <input
              type="email"
              placeholder="example@email.com"
              className="txtb"
              required
              value={this.state.email}
              onChange={this.updateEmail}
            />
           
            <input
              type="submit"
              value="Reset Password"
              className="newPassword-btn"
              onClick={this.requestNewPassword}
            />
            <Link id="link" to="/login">
              Sign in
            </Link>
          </div>
        </div>
      </div>
    );
  }
}
