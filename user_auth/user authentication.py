import hashlib
import jwt
import time

SECRET_KEY = 'your_secret_key'  # Change this to a strong secret key
ALGORITHM = 'HS256'
TOKEN_EXPIRY = 3600  # Token expires in 1 hour

users = {
    'user1': '5f4dcc3b5aa765d61d8327deb882cf99',  # pre-hashed password for 'password'
}

def hash_password(password):
    """Hash a password using MD5 (can replace with stronger algorithm)."""
    return hashlib.md5(password.encode()).hexdigest()

def get_user_from_db(username):
    """Fetch a user record from the 'database'."""
    if username in users:
        return {'username': username, 'password_hash': users[username]}
    return None

def generate_token(username):
    """Generate JWT token for authenticated user."""
    payload = {
        'username': username,
        'exp': time.time() + TOKEN_EXPIRY
    }
    token = jwt.encode(payload, SECRET_KEY, algorithm=ALGORITHM)
    return token

def verify_token(token):
    """Verify and decode JWT token."""
    try:
        payload = jwt.decode(token, SECRET_KEY, algorithms=[ALGORITHM])
        return payload['username']
    except jwt.ExpiredSignatureError:
        return None
    except jwt.InvalidTokenError:
        return None
