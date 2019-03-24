"""This module will encode and parse the query string params."""

try:
    from urllib.parse import urlparse
except ImportError:
     from urlparse import urlparse


def parse_query_params(query_string):
    """
        Function to parse the query parameter string.
        """
    # Parse the query param string
    query_params = dict(urlparse_qs(query_string))
    # Get the value from the list
    query_params = {k: v[0] for k, v in query_params.items()}
    return query_params
