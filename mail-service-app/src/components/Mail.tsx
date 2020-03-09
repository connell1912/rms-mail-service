import React from 'react';

interface IMailState {
     FROM: string 
     FROMNAME: string
     to: string
     SMTP_USERNAME: string
     SMTP_PASSWORD: string
     HOST: string
     PORT: number
     SUBJECT: string
     BODY: string
}

export class MailComponent extends React.Component<any,IMailState> {

    constructor(props:any){
        super(props)
        this.state = {
            FROM: "", 
            FROMNAME: "",
            to: "",
            SMTP_USERNAME: "",
            SMTP_PASSWORD: "",
            HOST: "",
            PORT: 0,
            SUBJECT: "",
            BODY: ""
        }
    }

   

    render() {
        return (
            <div>
                 this.mail
            </div>
        )
    }
    
    }