from flask import request, jsonify
from functools import wraps
import jwt

from auth import verify_token

SECRET_KEY = 'your_secret_key'

def token_required(f):
    """Decorator function to ensure a valid token is present in the request header."""
    @wraps(f)
    def decorated_function(*args, **kwargs):
        token = None

        # Check if token is in the request header
        if 'Authorization' in request.headers:
            token = request.headers['Authorization'].split(" ")[1]  # Bearer <token>

        if not token:
            return jsonify({'error': 'Token is missing'}), 403

        try:
            username = verify_token(token)
            if not username:
                return jsonify({'error': 'Token is invalid or expired'}), 403
        except Exception as e:
            return jsonify({'error': str(e)}), 403

        return f(*args, **kwargs)
    
    return decorated_function
