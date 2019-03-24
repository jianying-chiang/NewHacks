public static void detectLabels(String filePath, PrintStream out) throws Exception, IOException {
  List<AnnotateImageRequest> requests = new ArrayList<>();
  FileInputStream file = new FileInputStream()
  ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

  Image img = Image.newBuilder().setContent(imgBytes).build();
  Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
  AnnotateImageRequest request =
      AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
  requests.add(request);

  try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
    BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
    List<AnnotateImageResponse> responses = response.getResponsesList();

    for (AnnotateImageResponse res : responses) {
      if (res.hasError()) {
        out.printf("Error: %s\n", res.getError().getMessage());
        return;
      }

      // For full list of available annotations, see http://g.co/cloud/vision/docs
      for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
        annotation.getAllFields().forEach((k, v) -> out.printf("%s : %s\n", k, v.toString()));
      }
    }
  }
}
