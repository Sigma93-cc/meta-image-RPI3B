SUMMARY = "my-image recipe"
DESCRIPTION = "Recipe created by A.Sigov"
LICENSE = "MIT"

require recipes-core/images/core-image-minimal.bb
IMAGE_BOOT_FILES:append = " waveshare35b-v2.dtbo;overlays/waveshare35b-v2.dtbo"
IMAGE_INSTALL:append = " kernel-module-ads7846"
#IMAGE_INSTALL:append = " qtbase boost"