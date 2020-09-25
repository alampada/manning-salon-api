import React, { Component } from 'react';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';


class ChooseSlot extends Component {
    constructor(props) {
        super(props);
        this.state = {
            slots: []
        }
        
    }

    render() {
        return (
            <div>
                <h1>{this.props.match.params.serviceId} - {this.props.match.params.serviceName}</h1>
            </div>
        )
    }
}

export default ChooseSlot;