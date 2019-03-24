import io
import os

# Imports the Google Cloud client library
from google.cloud import vision
from google.cloud.vision import types
from PIL import Image, ImageDraw


os.environ["GOOGLE_APPLICATION_CREDENTIALS"] = os.path.join(os.path.dirname(__file__), 'ramen-GoogleKEY.json')

from google.cloud import vision
# Instantiates a client
client = vision.ImageAnnotatorClient()

# The name of the image file to annotate
file_name = os.path.join(
    os.path.dirname(__file__),
    'resources/grocery.jpg')

with open(file_name, 'rb') as image_file:
    content = image_file.read()

image = vision.types.Image(content=content)

objects = client.object_localization(image=image).localized_object_annotations

print('Number of objects found: {}\n'.format(len(objects)))
im = Image.open(file_name)
object_ = objects[1]
for object_ in objects:
    print('{} (confidence: {})\n'.format(object_.name, object_.score))
    vects = object_.bounding_poly.normalized_vertices

    # vects[1].x*1000, vects[1].y*650,
    # vects[3].x*1000, vects[3].y*700
    draw = ImageDraw.Draw(im)
    draw.rectangle([
        vects[0].x*1000, vects[0].y*650,

        vects[2].x*1000, vects[2].y*700], None, 'purple', width=5)
im.save(os.path.join(
    os.path.dirname(__file__),
    'resources/'+'haha.jpg'), 'JPEG')
print('Saved new image to haha.jpg')
