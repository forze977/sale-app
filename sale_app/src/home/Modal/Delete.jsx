import React from 'react';
import { Modal, Button } from 'react-bootstrap';

export default class Delete extends React.PureComponent {
    render() {
        return (
            <Modal
                onHide={this.props.onCancel}
                show={this.props.show}
                size="lg"
                aria-labelledby="contained-modal-title-vcenter"
                centered
                backdrop="static"
            >
                <Modal.Header closeButton>
                    <Modal.Title id="contained-modal-title-vcenter">
                        Modal heading
                    </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <h4>Centered Modal</h4>
                    <p>
                        Cras mattis consectetur purus sit amet fermentum. Cras justo odio,
                        dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac
                        consectetur ac, vestibulum at eros.
                    </p>
                </Modal.Body>
                <Modal.Footer>
                    <Button onClick={this.props.onConfirm}>Confirm</Button>
                    <Button onClick={this.props.onCancel}>Cancel</Button>
                </Modal.Footer>
            </Modal>
        )
    }
}